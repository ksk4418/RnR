package cgi.rnr.company;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.Session;

@Entity(name = "State")
public class State {

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "stateID")
	@TableGenerator(name = "stateID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "stateID", allocationSize = 1)
	@Id
	@Column(name = "STATE_ID", length = 12, nullable = false)
	private long id;

	@Column(name = "ST_NM", length = 50, nullable = false)
	private String stateName;

	@Column(name = "ST_DISP_NM", length = 120, nullable = false)
	private String stateDisplayName;

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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateDisplayName() {
		return stateDisplayName;
	}

	public void setStateDisplayName(String stateDisplayName) {
		this.stateDisplayName = stateDisplayName;
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

}
