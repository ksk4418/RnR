package cgi.rnr.awards;

import java.io.Serializable;
import java.math.BigInteger;

public class AwardCriteriaView implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger id;

	private BigInteger awardId;

	private String awardName;

	private BigInteger verticalId;

	private String verticalName;

	private BigInteger projectId;

	private String projectName;

	private BigInteger companyId;

	private String companyName;

	private BigInteger continentId;

	private String continentName;

	private BigInteger countryId;

	private String countryName;

	private BigInteger stateId;

	private String stateName;

	private BigInteger locationId;

	private String locationName;

	private BigInteger cityId;

	private String cityName;

	private BigInteger subCityId;

	private String subCityName;

	private String criteriaName;

	private String awardCriteriaDesc;

	private float quotaPercentage;

	private int quotaQuantity;

	private int quotaAlinedToRole;

	private char activeFl;

	private String quotaAlinedToRoleName;

	private String quotaPer;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getAwardId() {
		return awardId;
	}

	public void setAwardId(BigInteger awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public BigInteger getVerticalId() {
		return verticalId;
	}

	public void setVerticalId(BigInteger verticalId) {
		this.verticalId = verticalId;
	}

	public String getVerticalName() {
		return verticalName;
	}

	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}

	public BigInteger getProjectId() {
		return projectId;
	}

	public void setProjectId(BigInteger projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public BigInteger getCompanyId() {
		return companyId;
	}

	public void setCompanyId(BigInteger companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigInteger getContinentId() {
		return continentId;
	}

	public void setContinentId(BigInteger continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public BigInteger getCountryId() {
		return countryId;
	}

	public void setCountryId(BigInteger countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public BigInteger getStateId() {
		return stateId;
	}

	public void setStateId(BigInteger stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public BigInteger getLocationId() {
		return locationId;
	}

	public void setLocationId(BigInteger locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public BigInteger getCityId() {
		return cityId;
	}

	public void setCityId(BigInteger cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public BigInteger getSubCityId() {
		return subCityId;
	}

	public void setSubCityId(BigInteger subCityId) {
		this.subCityId = subCityId;
	}

	public String getSubCityName() {
		return subCityName;
	}

	public void setSubCityName(String subCityName) {
		this.subCityName = subCityName;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getAwardCriteriaDesc() {
		return awardCriteriaDesc;
	}

	public void setAwardCriteriaDesc(String awardCriteriaDesc) {
		this.awardCriteriaDesc = awardCriteriaDesc;
	}

	public float getQuotaPercentage() {
		return quotaPercentage;
	}

	public void setQuotaPercentage(float quotaPercentage) {
		this.quotaPercentage = quotaPercentage;
	}

	public int getQuotaQuantity() {
		return quotaQuantity;
	}

	public void setQuotaQuantity(int quotaQuantity) {
		this.quotaQuantity = quotaQuantity;
	}

	public int getQuotaAlinedToRole() {
		return quotaAlinedToRole;
	}

	public void setQuotaAlinedToRole(int quotaAlinedToRole) {
		this.quotaAlinedToRole = quotaAlinedToRole;
	}

	public char getActiveFl() {
		return activeFl;
	}

	public void setActiveFl(char activeFl) {
		this.activeFl = activeFl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQuotaAlinedToRoleName() {
		return quotaAlinedToRoleName;
	}

	public void setQuotaAlinedToRoleName(String quotaAlinedToRoleName) {
		this.quotaAlinedToRoleName = quotaAlinedToRoleName;
	}

	public String getQuotaPer() {
		return quotaPer;
	}

	public void setQuotaPer(String quotaPer) {
		this.quotaPer = quotaPer;
	}

}
