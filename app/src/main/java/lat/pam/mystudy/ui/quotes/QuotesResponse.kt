package lat.pam.mystudy.ui.quotes

data class QuotesResponse(
    val quotes: List<Quote>
)

data class Quote(
    val quote: String,
    val author: String
)

