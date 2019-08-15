package me.zhengjie.modules.system.dojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Entity
@Table(name = "act_re_model")
public class ModelA {
    @Id
    @Column(name = "ID_")
    private String id;
    private Long REV_;
    private String NAME_;
    private String KEY_;
    private String CATEGORY_;
    private Date CREATE_TIME_;
    private String LAST_UPDATE_TIME_;
    private Long VERSION_;
    private String META_INFO_;
    private String DEPLOYMENT_ID_;
    private String EDITOR_SOURCE_VALUE_ID_;
    private String EDITOR_SOURCE_EXTRA_VALUE_ID_;
    private String TENANT_ID_;

    @Override
    public String toString() {
        return "AppModel{" +
                "id='" + id + '\'' +
                ", REV_=" + REV_ +
                ", NAME_='" + NAME_ + '\'' +
                ", KEY_='" + KEY_ + '\'' +
                ", CATEGORY_='" + CATEGORY_ + '\'' +
                ", CREATE_TIME_=" + CREATE_TIME_ +
                ", LAST_UPDATE_TIME_='" + LAST_UPDATE_TIME_ + '\'' +
                ", VERSION_=" + VERSION_ +
                ", META_INFO_='" + META_INFO_ + '\'' +
                ", DEPLOYMENT_ID_='" + DEPLOYMENT_ID_ + '\'' +
                ", EDITOR_SOURCE_VALUE_ID_='" + EDITOR_SOURCE_VALUE_ID_ + '\'' +
                ", EDITOR_SOURCE_EXTRA_VALUE_ID_='" + EDITOR_SOURCE_EXTRA_VALUE_ID_ + '\'' +
                ", TENANT_ID_='" + TENANT_ID_ + '\'' +
                '}';
    }
}
