/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package org.quartz.impl.jdbcjobstore.oracle.weblogic;

import org.slf4j.Logger;
import org.quartz.impl.jdbcjobstore.oracle.OracleDelegate;
import org.quartz.spi.ClassLoadHelper;

import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handle Blobs correctly when Oracle is being used inside of Weblogic 8.1,
 * as discussed at: http://edocs.bea.com/wls/docs81/jdbc/thirdparty.html#1043705
 *  
 * @see org.quartz.impl.jdbcjobstore.WebLogicDelegate
 * @author James House
 * @author Igor Fedulov <a href="mailto:igor@fedulov.com">igor@fedulov.com</a>
 */
public class WebLogicOracleDelegate extends OracleDelegate {

    /**
     * Check for the Weblogic Blob wrapper, and handle accordingly...
     */
    @Override
    protected Blob writeDataToBlob(ResultSet rs, int column, byte[] data) throws SQLException {
        Blob blob = rs.getBlob(column);
        
        if (blob == null) { 
            throw new SQLException("Driver's Blob representation is null!");
        }
        
        // handle thin driver's blob
        return super.writeDataToBlob(rs, column, data);
    }
}
