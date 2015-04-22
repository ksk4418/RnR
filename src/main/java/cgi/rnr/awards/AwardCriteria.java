package cgi.rnr.awards;

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

@Entity(name = "AwardCriteria")
@Table(name = "AwardCriteria", uniqueConstraints = { @UniqueConstraint(columnNames = { "AWARD_ID" }) })
public class AwardCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "awardCriteriaId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "awardCriteriaId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "awardCriteriaId")
	@Column(name = "AWARD_CRITERIA_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "AWARD_ID", length = 20, nullable = false)
	private long awardId;

	@Column(name = "VERTICAL_ID", length = 20, nullable = true)
	private long verticalId;

	@Column(name = "PROJECT_ID", length = 20, nullable = true)
	private long projectId;

	@Column(name = "COMPANY_ID", length = 20, nullable = true)
	private long companyId;

	@Column(name = "CONTINENT_ID", length = 20, nullable = true)
	private long continentId;

	@Column(name = "COUNTRY_ID", length = 20, nullable = true)
	private long countryId;

	@Column(name = "STATE_ID", length = 20, nullable = true)
	private long stateId;

	@Column(name = "LOCATION_ID", length = 20, nullable = true)
	private long locationId;

	@Column(name = "CITY_ID", length = 20, nullable = true)
	private long cityId;

	@Column(name = "SUB_CITY_ID", length = 20, nullable = true)
	private long subCityId;

	@Column(name = "CRITERIA_NM", length = 120, nullable = false)
	private String criteriaName;

	@Column(name = "CRITERIA_DESC", length = 250, nullable = false)
	private String awardCriteriaDesc;

	@Column(name = "QUOTA_PC", scale = 5, precision = 2, nullable = false)
	private float quotaPercentage = 0;

	@Column(name = "QUOTA_QTY", scale = 5, nullable = false)
	private int quotaQuantity = 0;

	@Column(name = "QUOTA_ALINGNED_TO", scale = 1, nullable = false)
	private int quotaAlinedToRole = 3;

	@Column(name = "ACTIVE", nullable = false, length = 1)
	private char activeFl = 'N';

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "LAST_UP_UID", nullable = true, length = 50)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAwardId() {
		return awardId;
	}

	public void setAwardId(long awardId) {
		this.awardId = awardId;
	}

	public long getVerticalId() {
		return verticalId;
	}

	public void setVerticalId(long verticalId) {
		this.verticalId = verticalId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getContinentId() {
		return continentId;
	}

	public void setContinentId(long continentId) {
		this.continentId = continentId;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public long getSubCityId() {
		return subCityId;
	}

	public void setSubCityId(long subCityId) {
		this.subCityId = subCityId;
	}

	public String getAwardCriteriaName() {
		return criteriaName;
	}

	public void setAwardCriteriaName(String criteriaName) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

}
