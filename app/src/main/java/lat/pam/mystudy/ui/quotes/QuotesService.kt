package lat.pam.mystudy.ui.quotes

import retrofit2.http.GET

interface QuotesService {
    @GET("quotes")
    suspend fun getAllQuotes(): QuotesResponse
}


