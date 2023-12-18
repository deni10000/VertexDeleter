

import cgvsu.math.Vector3f;
import cgvsu.model.Model;
import cgvsu.model.Polygon;
import cgvsu.objwriter.ObjWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static cgvsu.deleteVertex.VertexDeleter.deleteVertices;

public class VertexDeleterTest {
    public static boolean testDeleteVertices(int k) {
        Model model = new Model();
        model.vertices = new ArrayList<>();
        model.polygons = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            model.vertices.add(new Vector3f(i, 0, 0));
            model.vertices.add(new Vector3f(i + 0.25f, 1, 0));
            model.vertices.add(new Vector3f(i + 0.5f, 0, 0));
            Polygon polygon = new Polygon();
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i*3, i*3+1, i*3+2))  ;
            polygon.setVertexIndices(list);
            model.polygons.add(polygon);
        }
        boolean ret = true;
        for(int i = 0; i < 3*k; i++) {
            deleteVertices(model, 0);
            ret = ret && (model.polygons.size() == k - i / 3 - 1) && (model.vertices.size() == k*3 - 1 - i) &&
                    (model.polygons.isEmpty() || (model.polygons.get(0).getVertexIndices().get(0) == 2 - i % 3 &&
                            model.polygons.getLast().getVertexIndices().getLast() == 3*k - 2 - i)) ;
        }
        return ret;
    }
    public static boolean testDeleteVertices1(int k) {
        Model model = new Model();
        model.vertices = new ArrayList<>();
        model.polygons = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            model.vertices.add(new Vector3f(i, 0, 0));
            model.vertices.add(new Vector3f(i + 0.25f, 1, 0));
            model.vertices.add(new Vector3f(i + 0.5f, 0, 0));
            Polygon polygon = new Polygon();
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i*3, i*3+1, i*3+2))  ;
            polygon.setVertexIndices(list);
            model.polygons.add(polygon);
        }
        boolean ret = true;
        for(int i = 0; i < 3*k; i++) {
            deleteVertices(model, 3*k - 1 - i);
            ret = ret && (model.polygons.size() == k - i / 3 - 1) && (model.vertices.size() == k*3 - 1 - i) ;
        }
        return ret;
    }
    @Test
    public void testDeleteVertices01() {
        Assertions.assertTrue(testDeleteVertices(10));
        Assertions.assertTrue(testDeleteVertices1(10));
    }
    @Test
    public void testDeleteVertices02() {
        Assertions.assertTrue(testDeleteVertices(14));
        Assertions.assertTrue(testDeleteVertices1(14));

    }
    @Test
    public void testDeleteVertices03() {
        Assertions.assertTrue(testDeleteVertices(18));
        Assertions.assertTrue(testDeleteVertices1(18));

    }

    @Test
    public void testDeleteVertices04() {
        int k = 100;
        Model model = new Model();
        model.vertices = new ArrayList<>();
        model.polygons = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            model.vertices.add(new Vector3f(i, 0, 0));
        }
        model.vertices.add(new Vector3f(5, 5, 0));
        for(int i = 0; i < k - 1; i++) {
            Polygon polygon = new Polygon();
            polygon.setVertexIndices(new ArrayList<>(Arrays.asList(i, i + 1, k)));
            model.polygons.add(polygon);
        }
        deleteVertices(model, k);
        Assertions.assertEquals(model.polygons.size(), 0);
    }


    @Test
    public void testDeleteVertices05() {
        int k = 100;
        Model model = new Model();
        model.vertices = new ArrayList<>();
        model.polygons = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            model.vertices.add(new Vector3f(i, 0, 0));
        }
        model.vertices.add(new Vector3f(5, 5, 0));
        for(int i = 0; i < k - 1; i++) {
            Polygon polygon = new Polygon();
            polygon.setVertexIndices(new ArrayList<>(Arrays.asList(i, i + 1, k)));
            model.polygons.add(polygon);
        }
        model.polygons.add(new Polygon(new ArrayList<>(Arrays.asList(0, 1, 2))));
        deleteVertices(model, k, k-1, k-2);
        Assertions.assertEquals(model.polygons.size(), 1);
        Assertions.assertEquals(model.vertices.size(), k - 2);
    }
}
