package cn.edu.buaa.lab.robot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "r_user")
public class UserModel extends BaseModel {

    @Column(name = "machine_code")
    private String machineCode;

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }
}
