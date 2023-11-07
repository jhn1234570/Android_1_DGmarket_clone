import androidx.room.Entity
import java.io.Serializable

// TODO: RecyclerView에 들어갈 item을 구성할 때 필요한 정보에는 무엇이 있을지 생각해보고 data class로 만들기
// 예시: 사진(썸네일), 글 제목, 사는 곳, 시간, 가격, ..
// .
//@Entity(tableName = "ProductStringTable") -> 7주차 미션
data class ProductInfo(
    val title:String,
    val residence:String,
    val price:String,
    val comment:String,
    val like:String
): Serializable

// @Primary key 입력