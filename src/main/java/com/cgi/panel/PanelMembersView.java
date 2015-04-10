package com.cgi.panel;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class PanelMembersView implements Serializable {

   private BigInteger panelMemberId;

   private BigInteger panelId;
   private String panelName;

   private String memberUID;

   public BigInteger getPanelMemberId() {
      return panelMemberId;
   }

   public void setPanelMemberId(BigInteger panelMemberId) {
      this.panelMemberId = panelMemberId;
   }

   public BigInteger getPanelId() {
      return panelId;
   }

   public void setPanelId(BigInteger panelId) {
      this.panelId = panelId;
   }

   public String getPanelName() {
      return panelName;
   }

   public void setPanelName(String panelName) {
      this.panelName = panelName;
   }

   public String getMemberUID() {
      return memberUID;
   }

   public void setMemberUID(String memberUID) {
      this.memberUID = memberUID;
   }

}
