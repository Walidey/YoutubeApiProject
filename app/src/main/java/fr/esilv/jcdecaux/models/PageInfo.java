
package fr.esilv.jcdecaux.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageInfo implements Serializable
{

    @SerializedName("totalResults")
    @Expose
    private int totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    private int resultsPerPage;
    private final static long serialVersionUID = -5877003706095913305L;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

}
