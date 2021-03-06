/*
 *    Copyright 2015 Benjamin Schmid, @bentolor
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package bentolor.grocerylist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jodd.madvoc.ActionRequest;
import jodd.madvoc.result.ActionResult;
import jodd.util.net.MimeTypes;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JsonResultRenderer implements ActionResult<JsonResult> {

    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    @Override
    public void render(ActionRequest request, JsonResult jsonResult) throws Exception {
        HttpServletResponse response = request.getHttpServletResponse();
        response.setContentType(MimeTypes.MIME_APPLICATION_JSON);

        if (jsonResult.getStatus() > 0) {
            response.setStatus(jsonResult.getStatus());
        }

        try (PrintWriter writer = response.getWriter()) {
            String result = gson.toJson(jsonResult.getModel());
            writer.println(result);
        }
    }

}