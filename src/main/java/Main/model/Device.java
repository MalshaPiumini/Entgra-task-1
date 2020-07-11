package Main.model;

import javax.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "deviceName",nullable = false)
    private String deviceName;
    @Column(name = "deviceStatus")
    private String deviceStatus;
    @Column(name = "deviceModel")
    private String deviceModel;
    @Column(name = "enrolledTime")
    private int enrolledTime;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public int getEnrolledTime() {
        return enrolledTime;
    }

    public void setEnrolledTime(int enrolledTime) {
        this.enrolledTime = enrolledTime;
    }
}
