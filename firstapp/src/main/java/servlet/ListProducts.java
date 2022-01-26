package servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ListProducts", urlPatterns = "/list_products")
public class ListProducts extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ListProducts.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("List products");

        resp.getWriter().printf("<h1>List products</h1>");
        resp.getWriter().printf("<table>" +
                "<tr><th>ID</th><th>  Title  </th><th>  Cost  </th></tr>");
        Producttt[] products = Producttt.getProduct();
        for (Producttt product : products) {
            resp.getWriter().printf("<tr><td>%d</td><td>%s</td><td>%d</td></tr>",
                    product.getId(), product.getTitle(), product.getCost());
        }
        resp.getWriter().printf("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");

        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}