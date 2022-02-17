package Tool;

public class Cutter extends Tools {


    private CutterGeometry geometry;

    public Cutter(int id, String productCode, double diameter, double edgeLength, ToolMaterial material, Boolean coated,
                  String description, Boolean critic,CutterGeometry geometry,
                  int numberOfEdge, int numOfMin, int quantity) {
        super(id, productCode, diameter, edgeLength, material, coated, description, critic,
                numberOfEdge, numOfMin, quantity);
        this.geometry = geometry;
    }

    public Cutter(String productCode, double diameter, double edgeLength, ToolMaterial material, Boolean coated,
                  String description, Boolean critic,CutterGeometry geometry, int numberOfEdge) {
        super(productCode, diameter, edgeLength, material, coated,
                description, critic, numberOfEdge);
        this.geometry = geometry;
    }


    public CutterGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(CutterGeometry geometry) {
        this.geometry = geometry;
    }
}
