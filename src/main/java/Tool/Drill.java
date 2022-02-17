package Tool;

public class Drill extends Tools {

    private DrillGeometry geometry;


    public Drill(int id, String productCode, double diameter, double edgeLength, ToolMaterial material, Boolean coated,
                 String description, Boolean critic,DrillGeometry geometry, int numberOfEdge, int numOfMin, int quantity) {
        super(id, productCode, diameter, edgeLength, material, coated, description, critic, numberOfEdge, numOfMin, quantity);
    this.geometry = geometry;
    }

    public Drill(String productCode, double diameter, double edgeLength, ToolMaterial material,
                 Boolean coated, String description, Boolean critic,DrillGeometry geometry, int numberOfEdge) {
        super(productCode, diameter, edgeLength, material, coated, description, critic, numberOfEdge);
        this.geometry = geometry;
    }

    public DrillGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(DrillGeometry geometry) {
        this.geometry = geometry;
    }
}
