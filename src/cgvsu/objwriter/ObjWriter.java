package cgvsu.objwriter;
import cgvsu.math.Vector2f;
import cgvsu.math.Vector3f;
import cgvsu.model.Model;
import cgvsu.model.Polygon;

import java.util.ArrayList;

public class ObjWriter {
    public static String modelToString(Model model) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Vector3f v: model.vertices) {
            stringBuilder.append("v " + v.x + " " + v.y + " " + v.z + "\n");
        }
        for (Vector2f v: model.textureVertices) {
            stringBuilder.append("vt " + v.x + " " + v.y  + "\n");
        }
        for (Vector3f v: model.normals) {
            stringBuilder.append("vn " + v.x + " " + v.y + " " + v.z + "\n");
        }
        for (Polygon p: model.polygons) {
            int size =  p.getVertexIndices().size();
            stringBuilder.append("f");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(" " + (p.getVertexIndices().get(i) + 1));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
