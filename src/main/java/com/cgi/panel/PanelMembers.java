package com.cgi.panel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "PanelMembers")
public class PanelMembers implements Serializable {
   @Id
   @TableGenerator(name = "panelMemberId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "panelMemberId", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "panelMemberId")
   @Column(name = "PANEL_MEM_ID", length = 20, nullable = false)
   private long panelMemberId;

   @Column(name = "PANEL_ID", length = 20, nullable = false)
   private long panelId;

   @Column(name = "MEMBER_UID", length = 120, nullable = false)
   private String memberUID;

   @Column(name = "LAST_UP_DT", nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private Date lastUpdateDate = new Date();

   @Column(name = "LAST_UP_UID", nullable = true, length = 50)
   private String lastUpdateUID;

   @Column(name = "VERS_NO", nullable = true)
   private int rowVersionNumber;

   public long getPanelMemberId() {
      return panelMemberId;
   }

   public void setPanelMemberId(long panelMemberId) {
      this.panelMemberId = panelMemberId;
   }

   public long getPanelId() {
      return panelId;
   }

   public void setPanelId(long panelId) {
      this.panelId = panelId;
   }

   public String getMemberUID() {
      return memberUID;
   }

   public void setMemberUID(String memberUID) {
      this.memberUID = memberUID;
   }

   public Date getLastUpdateDate() {
      return lastUpdateDate;
   }

   public void setLastUpdateDate(Date lastUpdateDate) {
      this.lastUpdateDate = lastUpdateDate;
   }

   public String getLastUpdateUID() {
      return lastUpdateUID;
   }

   public void setLastUpdateUID(String lastUpdateUID) {
      this.lastUpdateUID = lastUpdateUID;
   }

   public int getRowVersionNumber() {
      return rowVersionNumber;
   }

   public void setRowVersionNumber(int rowVersionNumber) {
      this.rowVersionNumber = rowVersionNumber;
   }

}
