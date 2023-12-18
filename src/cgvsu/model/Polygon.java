package cgvsu.model;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;

public class Polygon {


    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;


    public Polygon() {
        vertexIndices = new ArrayList<Integer>();
        textureVertexIndices = new ArrayList<Integer>();
        normalIndices = new ArrayList<Integer>();
    }

    public Polygon(ArrayList<Integer> vI, ArrayList<Integer> tI, ArrayList<Integer> nI) {
        this();
        if (vI != null)
            vertexIndices.addAll(vI);
        if (tI != null)
            textureVertexIndices.addAll(tI);
        if (nI != null)
            normalIndices.addAll(nI);
    }
    public Polygon(ArrayList<Integer> vI) {
        this(vI, null, null);
    }


    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        assert vertexIndices.size() >= 3;
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        assert textureVertexIndices.size() >= 3;
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        assert normalIndices.size() >= 3;
        this.normalIndices = normalIndices;
    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }
}
