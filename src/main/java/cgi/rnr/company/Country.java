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

@Entity(name = "Country")
@Table(name = "Country", uniqueConstraints = { @UniqueConstraint(columnNames = { "CNTRY_NM" }) })
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "countryID")
	@TableGenerator(name = "countryID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "countryID", allocationSize = 1)
	@Id
	@Column(name = "CNTRY_ID", nullable = false, length = 12)
	private long id;

	@Column(name = "CNTRY_NM", nullable = false, length = 50)
	private String countryName;

	@Column(name = "CNTRY_DISP_NM", nullable = false, length = 120)
	private String countryDisplayName;

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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryDisplayName() {
		return countryDisplayName;
	}

	public void setCountryDisplayName(String countryDisplayName) {
		this.countryDisplayName = countryDisplayName;
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
