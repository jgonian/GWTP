/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.tester;

import com.google.gwt.user.client.Command;

import java.util.LinkedList;
import java.util.List;

/**
 * This class mimicks GWT's {@link com.google.gwt.user.client.DeferredCommand}
 * but it can be used in test cases without having to rely on a
 * {@link com.google.gwt.junit.client.GWTTestCase}.
 * <p />
 * Use {@link #addCommand(Command)} to add deferred commands, then call
 * {@link #pump()} to process all the deferred commands.
 *
 * @author Philippe Beaudoin
 */
public class DeferredCommandManager {

  private List<Command> commands = new LinkedList<Command>();

  public void addCommand(Command command) {
    commands.add(command);
  }

  public void pump() {
    while (!commands.isEmpty()) {
      commands.remove(0).execute();
    }
  }

}
