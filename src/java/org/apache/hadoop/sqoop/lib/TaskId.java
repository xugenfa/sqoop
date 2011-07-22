/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.sqoop.lib;

import org.apache.hadoop.conf.Configuration;

/**
 * Utility class; returns task attempt Id of the current job
 * regardless of Hadoop version being used.
 */
public final class TaskId {

  private TaskId() {
  }

  /**
   * @param conf the Configuration to check for the current task attempt id.
   * @param defaultVal the value to return if a task attempt id is not set.
   * @return the current task attempt id, or the default value if one isn't set.
   */
  public static String get(Configuration conf, String defaultVal) {
    return conf.get("mapreduce.task.id",
        conf.get("mapred.task.id", defaultVal));
  }
}