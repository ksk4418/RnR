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

@Entity(name = "Company")
@Table(name = "Company", uniqueConstraints = { @UniqueConstraint(columnNames = { "CMP_NM" }) })
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "companyID", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "companyID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "companyID")
	@Id
	@Column(name = "CMP_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "CMP_NM", length = 50, nullable = false)
	private String companyName;

	@Column(name = "CMP_STRT_DT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date companyStartDate;

	@Column(name = "CMP_DISP_NM", length = 120, nullable = false)
	private String companyDisplayName;

	@Column(name = "LAST_UP_DT", nullable = true)
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCompanyStartDate() {
		return companyStartDate;
	}

	public void setCompanyStartDate(Date companyStartDate) {
		this.companyStartDate = companyStartDate;
	}

	public String getCompanyDisplayName() {
		return companyDisplayName;
	}

	public void setCompanyDisplayName(String companyDisplayName) {
		this.companyDisplayName = companyDisplayName;
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
