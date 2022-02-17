package Tool;

public abstract class Tools {

    private int id;
    private String productCode;
    private double diameter;
    private double edgeLength;
    private ToolMaterial material;
    private Boolean coated;
    private String description;
    private Boolean critic;
    private int numberOfEdge;
    private int numOfMin;
    private int quantity;

    public Tools(int id, String productCode, double diameter, double edgeLength, ToolMaterial material
            , Boolean coated, String description, Boolean critic, int numberOfEdge, int numOfMin, int quantity) {
        this.id = id;
        this.productCode = productCode;
        this.diameter = diameter;
        this.edgeLength = edgeLength;
        this.material = material;
        this.coated = coated;
        this.description = description;
        this.critic = critic;
        this.numberOfEdge = numberOfEdge;
        this.numOfMin = numOfMin;
        this.quantity = quantity;
    }

    public Tools(String productCode, double diameter, double edgeLength, ToolMaterial material, Boolean coated,
                 String description, Boolean critic, int numberOfEdge) {
        this.productCode = productCode;
        this.diameter = diameter;
        this.edgeLength = edgeLength;
        this.material = material;
        this.coated = coated;
        this.description = description;
        this.critic = critic;
        this.numberOfEdge = numberOfEdge;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                        ",type = '" + this.getClass()+
                        ", productCode=" + productCode + '\'' +
                        ", diameter=" + diameter +
                        ", edgeLength=" + edgeLength +
                        ", material=" + material +
                        ", coated=" + coated +
                        ", description='" + description + '\'' +
                        ", critic=" + critic +
                        ", numberOfEdge=" + numberOfEdge +
                        ", quantity=" + quantity;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    public ToolMaterial getMaterial() {
        return material;
    }

    public void setMaterial(ToolMaterial material) {
        this.material = material;
    }

    public Boolean getCoated() {
        return coated;
    }

    public void setCoated(Boolean coated) {
        this.coated = coated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCritic() {
        return critic;
    }

    public void setCritic(Boolean critic) {
        this.critic = critic;
    }

    public int getNumOfMin() {
        return numOfMin;
    }

    public void setNumOfMin(int numOfMin) {
        this.numOfMin = numOfMin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNumberOfEdge() {
        return numberOfEdge;
    }

    public void setNumberOfEdge(int numberOfEdge) {
        this.numberOfEdge = numberOfEdge;
    }
}
