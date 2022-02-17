package Product;

import Tool.Tools;

import java.util.List;

public class Product {

    private int id;
    private double width;
    private double length;
    private double height;
    private Material material;
    private Boolean needHeatTreatment;
    private List<Tools> tools;

    public Product(double width, double length, double height, Material material, Boolean needHeatTreatment) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.material = material;
        this.needHeatTreatment = needHeatTreatment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Boolean getNeedHeatTreatment() {
        return needHeatTreatment;
    }

    public void setNeedHeatTreatment(Boolean needHeatTreatment) {
        this.needHeatTreatment = needHeatTreatment;
    }

    public List<Tools> getTools() {
        return tools;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }
}
