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

@Entity(name = "City")
@Table(name = "City", uniqueConstraints = { @UniqueConstraint(columnNames = { "CITY_NM" }) })
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "cityID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "cityID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cityID")
	@Id
	@Column(name = "CITY_ID", nullable = false, length = 12)
	private long id;

	@Column(name = "CITY_NM", nullable = false, length = 50)
	private String cityName;

	@Column(name = "CITY_DISP_NM", nullable = false, length = 120)
	private String cityDisplayName;

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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityDisplayName() {
		return cityDisplayName;
	}

	public void setCityDisplayName(String cityDisplayName) {
		this.cityDisplayName = cityDisplayName;
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