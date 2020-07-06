package kr.co.fastcampus.eatgo.domain;

import ch.qos.logback.core.BasicStatusManager;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    @Transient
    private List<MenuItem> menuItems;

    public String getInformation() {
//        return "";
//        return name + " in Seoul";
        return name + " in " + address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addMenuItem(MenuItem menuItem) {

        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }
    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
