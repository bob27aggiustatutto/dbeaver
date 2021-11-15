/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2021 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.tools.transfer.finalizer;

import org.jkiss.code.NotNull;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;
import org.jkiss.dbeaver.runtime.DBWorkbench;
import org.jkiss.dbeaver.tools.transfer.IDataTransferFinalizer;
import org.jkiss.dbeaver.tools.transfer.stream.StreamTransferConsumer;

import java.io.File;
import java.util.Map;

public class ShowInExplorerFinalizer implements IDataTransferFinalizer {
    @Override
    public void handle(@NotNull DBRProgressMonitor monitor, @NotNull Event event, @NotNull StreamTransferConsumer consumer, @NotNull Map<String, Object> settings) throws DBException {
        if (!consumer.getSettings().isOutputClipboard()) {
            final String folder = consumer.getOutputFolder();
            final String filename = consumer.getOutputFileName();
            DBWorkbench.getPlatformUI().showInSystemExplorer(new File(folder, filename).getAbsolutePath());
        }
    }
}
