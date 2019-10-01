/*
 * Copyright (c) 2008-2019, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.sql;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.sql.impl.SqlCursorImpl;
import com.hazelcast.sql.model.ModelGenerator;
import com.hazelcast.test.HazelcastTestSupport;
import com.hazelcast.test.TestHazelcastInstanceFactory;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * Common infrastructure for SQL tests.
 */
public class SqlTestSupport extends HazelcastTestSupport {
    protected SqlCursorImpl executeQuery(HazelcastInstance target, String sql) {
        SqlCursor cursor = target.getSqlService().query(sql);

        return (SqlCursorImpl) cursor;
    }

    protected List<SqlRow> getQueryRows(HazelcastInstance target, String sql) {
        SqlCursor cursor = executeQuery(target, sql);

        List<SqlRow> rows = new ArrayList<>();

        for (SqlRow row : cursor) {
            rows.add(row);
        }

        return rows;
    }
}