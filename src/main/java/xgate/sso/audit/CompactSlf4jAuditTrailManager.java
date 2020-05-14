/**
 * 
 */
package xgate.sso.audit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Set;

import org.apereo.inspektr.audit.AuditActionContext;
import org.apereo.inspektr.audit.AuditTrailManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author Jason.lee
 *
 */
public class CompactSlf4jAuditTrailManager implements AuditTrailManager{
	
	/** Logger category for audit trail messages, {@value}. */
    public static final String CATEGORY = "AUDIT";

    /** Logger that prints audit trail messages. */
    private final Logger logger = LoggerFactory.getLogger(CATEGORY);

    /** Date formatter. */
    private final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");


	@Override
	public void record(AuditActionContext context) {
		 final StringBuilder sb = new StringBuilder(formatter.format( context.getWhenActionWasPerformed()));		
	        sb.append('|').append(context.getResourceOperatedUpon());
	        sb.append('|').append(context.getPrincipal());
	        sb.append('|').append(context.getActionPerformed());
	        sb.append('|').append(context.getClientIpAddress());
	        logger.info(sb.toString());

	}

	@Override
	public Set<? extends AuditActionContext> getAuditRecordsSince(LocalDate sinceDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
