package com.m.x.picture.security.persistent.model;


import com.m.x.picture.security.persistent.model.base.CreateHaveVersion;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "system_url")
public class SystemUrlModel extends CreateHaveVersion {

  private String url;
  private String describe;
  private Boolean status;

}
