package com.hoanganhnhan.catalog.models;
//import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;

import java.io.Serializable;

@IgnoreExtraProperties
public class Laptop implements Serializable {

    @PropertyName("laptop_id")
    public String laptopID;

    @PropertyName("laptop_name")
    public String laptopName;

    @PropertyName("laptop_des")
    public String laptopDescription;

    @PropertyName("laptop_price")
    public Double laptopPrice;

    @PropertyName("laptop_origin_price")
    public Double laptopOriginPrice;

    @PropertyName("laptop_os")
    public String laptopOS;

    @PropertyName("laptop_cpu")
    public String laptopCPU;

    @PropertyName("laptop_gpu")
    public String laptopGPU;

    @PropertyName("laptop_ram")
    public String laptopRAM;

    @PropertyName("laptop_screen_resolution")
    public String laptopScreenResolution;

    @PropertyName("laptop_hard_disk")
    public String laptopHardDisk;

    @PropertyName("laptop_bluetooth")
    public String laptopBluetooth;

    @PropertyName("laptop_wifi")
    public String laptopWifi;

    @PropertyName("laptop_communication_gateway")
    public String laptopCommunicationGateway;

    @PropertyName("laptop_keyboard")
    public String laptopKeyboard;

    @PropertyName("laptop_screen_size")
    public String laptopScreenSize;

    @PropertyName("laptop_battery")
    public String laptopBattery;

    @PropertyName("laptop_weight")
    public String laptopWeight;

    @PropertyName("laptop_image_path")
    public String laptopImagePath;

    @PropertyName("laptop_demand_id")
    public String laptopDemandID;

    @PropertyName("laptop_brand_id")
    public String laptopBrandID;

    @PropertyName("laptop_quantity")
    public int laptopQuantity;

    public Laptop() {
    }

    public Laptop(String laptopID, String laptopName, String laptopDescription, Double laptopPrice, Double laptopOriginPrice, String laptopOS, String laptopCPU, String laptopGPU, String laptopRAM, String laptopScreenResolution, String laptopHardDisk, String laptopBluetooth, String laptopWifi, String laptopCommunicationGateway, String laptopKeyboard, String laptopScreenSize, String laptopBattery, String laptopWeight, String laptopImagePath, String laptopDemandID, String laptopBrandID, int laptopQuantity) {
        this.laptopID = laptopID;
        this.laptopName = laptopName;
        this.laptopDescription = laptopDescription;
        this.laptopPrice = laptopPrice;
        this.laptopOriginPrice = laptopOriginPrice;
        this.laptopOS = laptopOS;
        this.laptopCPU = laptopCPU;
        this.laptopGPU = laptopGPU;
        this.laptopRAM = laptopRAM;
        this.laptopScreenResolution = laptopScreenResolution;
        this.laptopHardDisk = laptopHardDisk;
        this.laptopBluetooth = laptopBluetooth;
        this.laptopWifi = laptopWifi;
        this.laptopCommunicationGateway = laptopCommunicationGateway;
        this.laptopKeyboard = laptopKeyboard;
        this.laptopScreenSize = laptopScreenSize;
        this.laptopBattery = laptopBattery;
        this.laptopWeight = laptopWeight;
        this.laptopImagePath = laptopImagePath;
        this.laptopDemandID = laptopDemandID;
        this.laptopBrandID = laptopBrandID;
        this.laptopQuantity = laptopQuantity;
    }

    public String getLaptopID() {
        return laptopID;
    }

    public void setLaptopID(String laptopID) {
        this.laptopID = laptopID;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getLaptopDescription() {
        return laptopDescription;
    }

    public void setLaptopDescription(String laptopDescription) {
        this.laptopDescription = laptopDescription;
    }

    public Double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(Double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public Double getLaptopOriginPrice() {
        return laptopOriginPrice;
    }

    public void setLaptopOriginPrice(Double laptopOriginPrice) {
        this.laptopOriginPrice = laptopOriginPrice;
    }

    public String getLaptopOS() {
        return laptopOS;
    }

    public void setLaptopOS(String laptopOS) {
        this.laptopOS = laptopOS;
    }

    public String getLaptopCPU() {
        return laptopCPU;
    }

    public void setLaptopCPU(String laptopCPU) {
        this.laptopCPU = laptopCPU;
    }

    public String getLaptopGPU() {
        return laptopGPU;
    }

    public void setLaptopGPU(String laptopGPU) {
        this.laptopGPU = laptopGPU;
    }

    public String getLaptopRAM() {
        return laptopRAM;
    }

    public void setLaptopRAM(String laptopRAM) {
        this.laptopRAM = laptopRAM;
    }

    public String getLaptopScreenResolution() {
        return laptopScreenResolution;
    }

    public void setLaptopScreenResolution(String laptopScreenResolution) {
        this.laptopScreenResolution = laptopScreenResolution;
    }

    public String getLaptopHardDisk() {
        return laptopHardDisk;
    }

    public void setLaptopHardDisk(String laptopHardDisk) {
        this.laptopHardDisk = laptopHardDisk;
    }

    public String getLaptopBluetooth() {
        return laptopBluetooth;
    }

    public void setLaptopBluetooth(String laptopBluetooth) {
        this.laptopBluetooth = laptopBluetooth;
    }

    public String getLaptopWifi() {
        return laptopWifi;
    }

    public void setLaptopWifi(String laptopWifi) {
        this.laptopWifi = laptopWifi;
    }

    public String getLaptopCommunicationGateway() {
        return laptopCommunicationGateway;
    }

    public void setLaptopCommunicationGateway(String laptopCommunicationGateway) {
        this.laptopCommunicationGateway = laptopCommunicationGateway;
    }

    public String getLaptopKeyboard() {
        return laptopKeyboard;
    }

    public void setLaptopKeyboard(String laptopKeyboard) {
        this.laptopKeyboard = laptopKeyboard;
    }

    public String getLaptopScreenSize() {
        return laptopScreenSize;
    }

    public void setLaptopScreenSize(String laptopScreenSize) {
        this.laptopScreenSize = laptopScreenSize;
    }

    public String getLaptopBattery() {
        return laptopBattery;
    }

    public void setLaptopBattery(String laptopBattery) {
        this.laptopBattery = laptopBattery;
    }

    public String getLaptopWeight() {
        return laptopWeight;
    }

    public void setLaptopWeight(String laptopWeight) {
        this.laptopWeight = laptopWeight;
    }

    public String getLaptopImagePath() {
        return laptopImagePath;
    }

    public void setLaptopImagePath(String laptopImagePath) {
        this.laptopImagePath = laptopImagePath;
    }

    public String getLaptopDemandID() {
        return laptopDemandID;
    }

    public void setLaptopDemandID(String laptopDemandID) {
        this.laptopDemandID = laptopDemandID;
    }

    public String getLaptopBrandID() {
        return laptopBrandID;
    }

    public void setLaptopBrandID(String laptopBrandID) {
        this.laptopBrandID = laptopBrandID;
    }

    public int getLaptopQuantity() {
        return laptopQuantity;
    }

    public void setLaptopQuantity(int laptopQuantity) {
        this.laptopQuantity = laptopQuantity;
    }
}