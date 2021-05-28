package ai.opelsolution.goodproverb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteList: List<Quotes> = listOf<Quotes>(
            Quotes("삶이 있는 한 희망은 있다.", "키케로"),
            Quotes("산다는것 그것은 치열한 전투이다.", "로망로랑"),
            Quotes("하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다.", "사무엘존슨"),
            Quotes("언제나 현재에 집중할수 있다면 행복할것이다.", "파울로 코엘료"),
            Quotes("진정으로 웃으려면 고통을 참아야하며, 나아가 고통을 즐길 줄 알아야 해", "찰리 채플린"),
        )

        var quote = quoteList.random()

        val textQuote = findViewById<TextView>(R.id.quote_quote)
        val textName = findViewById<TextView>(R.id.quote_name)
        val changeButton = findViewById<Button>(R.id.change_button)

        textQuote.text = quote.quote
        textName.text = quote.name

        changeButton.setOnClickListener {
            while(true){
                val temp = quoteList.random()
                if (temp != quote) {
                    quote = temp
                    break
                }
            }
            textQuote.text = quote.quote
            textName.text = quote.name
            Toast.makeText(this, "명언을 바꿨습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}

data class Quotes(val quote: String, val name: String)