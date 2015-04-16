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

@Entity(name = "Continent")
@Table(name = "Continent", uniqueConstraints = { @UniqueConstraint(columnNames = { "BUS_NM" }) })
public class Continent implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "continentID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "continentID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "continentID")
	@Column(name = "BUS_ID", nullable = false, length = 12)
	@Id
	private long id;

	@Column(name = "BUS_NM", nullable = false, length = 50)
	private String continentName;

	@Column(name = "BUS_DISP_NM", nullable = false, length = 120)
	private String continentDispName;

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

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getContinentDispName() {
		return continentDispName;
	}

	public void setContinentDispName(String continentDispName) {
		this.continentDispName = continentDispName;
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
