package com.cgi.panel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity(name = "Panel")
@Table(name = "Panel", uniqueConstraints = { @UniqueConstraint(columnNames = { "PANEL_NM" }) })
public class Panel implements Serializable {
   @Id
   @TableGenerator(name = "panelId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "panelId", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "panelId")
   @Column(name = "PANEL_ID", length = 20, nullable = false)
   private long panelId;

   @Column(name = "PANEL_NM", length = 120, nullable = false)
   private String panelName;

   @Column(name = "PANEL_DESC", length = 250, nullable = false)
   private String panelDescription;

   @Column(name = "TRSHLD", length = 3, nullable = false)
   private int treshold;

   @Column(name = "AUTO_GEN", length = 1, nullable = false)
   private char autoGenerate = 'N';

   @Column(name = "MIN_EXP", length = 10, nullable = false)
   private int minExpRequired = 1;

   @Column(name = "TITLE_GRP", length = 1, nullable = false)
   private int titleGroup = 1;

   //need to add backup panel group post threshold
   
   @Column(name = "LAST_UP_DT", nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private Date lastUpdateDate = new Date();

   @Column(name = "LAST_UP_UID", nullable = true, length = 50)
   private String lastUpdateUID;

   @Column(name = "VERS_NO", nullable = true)
   private int rowVersionNumber;

   public long getPanelId() {
      return panelId;
   }

   public void setPanelId(long panelId) {
      this.panelId = panelId;
   }

   public String getPanelName() {
      return panelName;
   }

   public void setPanelName(String panelName) {
      this.panelName = panelName;
   }

   public int getTreshold() {
      return treshold;
   }

   public void setTreshold(int treshold) {
      this.treshold = treshold;
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

   public String getPanelDescription() {
      return panelDescription;
   }

   public void setPanelDescription(String panelDescription) {
      this.panelDescription = panelDescription;
   }

   public char getAutoGenerate() {
      return autoGenerate;
   }

   public void setAutoGenerate(char autoGenerate) {
      this.autoGenerate = autoGenerate;
   }

   public int getMinExpRequired() {
      return minExpRequired;
   }

   public void setMinExpRequired(int minExpRequired) {
      this.minExpRequired = minExpRequired;
   }

   public int getTitleGroup() {
      return titleGroup;
   }

   public void setTitleGroup(int titleGroup) {
      this.titleGroup = titleGroup;
   }

}
