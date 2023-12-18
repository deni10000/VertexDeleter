package cgvsu.model;

import cgvsu.math.Vector2f;
import cgvsu.math.Vector3f;
import cgvsu.math.Vector2f;
import cgvsu.math.Vector3f;

import java.util.ArrayList;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<cgvsu.math.Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<cgvsu.math.Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();
}
