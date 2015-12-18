/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test.maven.archetype;

import com.opensymphony.xwork2.Action;
import junit.framework.TestCase;

/**
 * 
 */
public class FinallyTest extends TestCase {
    
    public void testFinally() throws Exception {
        int result = 1;
        result = getResult(result);

        assertEquals(2, result);
    }

    private int getResult(int result) {
        try {
            result=2;
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //注意：这里的代码是不会执行的
            result = 3;
        }
        return result;
    }
}
