package me.zhengjie.modules.system.dojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name="act_re_model")
public class AppModel {
    @Id
    @Column(name = "ID_")
    private String id;
    @Column(name = "REV_")
    private Long rev;
    @Column(name = "NAME_")
    private String name;
    @Column(name = "KEY_")
    private String key;
    @Column(name = "CATEGORY_")
    private String category;
    @Column(name = "CREATE_TIME_")
    private Date create_time;
    @Column(name = "LAST_UPDATE_TIME_")
    private String last_update_time;
    @Column(name = "VERSION_")
    private Long version;
    @Column(name = "META_INFO_")
    private String meta_info;
    @Column(name = "DEPLOYMENT_ID_")
    private String deployment_id;
    @Column(name = "EDITOR_SOURCE_VALUE_ID_")
    private String editor_source_value_id;
    @Column(name = "EDITOR_SOURCE_EXTRA_VALUE_ID_")
    private String editor_source_extra_value_id;
    @Column(name = "TENANT_ID_")
    private String tenant_id;

    @Override
    public String toString() {
        return "AppModel{" +
                "id='" + id + '\'' +
                ", rev=" + rev +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", category='" + category + '\'' +
                ", create_time=" + create_time +
                ", last_update_time='" + last_update_time + '\'' +
                ", version=" + version +
                ", meta_info='" + meta_info + '\'' +
                ", deployment_id='" + deployment_id + '\'' +
                ", editor_source_value_id='" + editor_source_value_id + '\'' +
                ", editor_source_extra_value_id='" + editor_source_extra_value_id + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }
}
