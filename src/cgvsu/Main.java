package cgvsu;

import cgvsu.model.Model;
import cgvsu.objreader.ObjReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static cgvsu.deleteVertex.VertexDeleter.deleteVertices;
import static cgvsu.objwriter.ObjWriter.modelToString;

public class Main {
    public static void saveModelWithDeletedVertex(String str, int... deletedVertex) throws IOException {
        String file = "3DModels\\SimpleModelsForReaderTests\\" + str;
        Path path = Path.of(file);
        String fileContent = Files.readString(path);
        Model model = ObjReader.read(fileContent);
        deleteVertices(model, deletedVertex);
        String newModel = modelToString(model);
        File file2 = new File("3DModels\\NewModels\\"+str);
        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.append(newModel);
        fileWriter.flush();
    }

    public static void main(String[] args) throws IOException {
        saveModelWithDeletedVertex("NonManifold.obj", 0);
        saveModelWithDeletedVertex("NonManifold2.obj", 0, 1);
        saveModelWithDeletedVertex("Teapot.obj", 0, 1, 2, 3, 4, 5, 6, 7);

    }
}
