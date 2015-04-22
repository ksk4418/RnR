package cgi.rnr.company;

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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.Session;

@Entity(name = "SubCity")
@Table(name = "SubCity", uniqueConstraints = { @UniqueConstraint(columnNames = { "SCITY_NM" }) })
public class SubCity implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "subCityID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "subCityID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "subCityID")
	@Id
	@Column(name = "SCITY_ID", length = 12, nullable = false)
	private long id;

	@Column(name = "SCITY_NM", length = 50, nullable = false)
	private String subCityName;

	@Column(name = "SCITY_DISP_NM", length = 120, nullable = false)
	private String subCityDisplayName;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDt = new Date();

	@Transient
	private Session session;

	@Column(name = "LAST_UP_UID", length = 50, nullable = true)
	private String lastUpdateUserId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubCityName() {
		return subCityName;
	}

	public void setSubCityName(String subCityName) {
		this.subCityName = subCityName;
	}

	public String getSubCityDisplayName() {
		return subCityDisplayName;
	}

	public void setSubCityDisplayName(String subCityDisplayName) {
		this.subCityDisplayName = subCityDisplayName;
	}

	public Date getLastUpdateDt() {
		return lastUpdateDt;
	}

	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
