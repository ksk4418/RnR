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

@Entity(name = "Location")
@Table(name = "Location", uniqueConstraints = { @UniqueConstraint(columnNames = { "LOC_NM" }) })
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "locationID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "locationID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "locationID")
	@Id
	@Column(name = "LOC_ID", length = 12, nullable = false)
	private long id;

	@Column(name = "LOC_NM", length = 50, nullable = false)
	private String locationName;

	@Column(name = "LOC_DISP_NM", length = 120, nullable = false)
	private String localtionDisplayName;

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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocaltionDisplayName() {
		return localtionDisplayName;
	}

	public void setLocaltionDisplayName(String localtionDisplayName) {
		this.localtionDisplayName = localtionDisplayName;
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
