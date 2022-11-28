package org.bumblebeecrew.blossom.Util

import android.content.ContentValues
import android.content.Context
import android.graphics.Point
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_viewmodel.BaseActivity
import org.mindrot.jbcrypt.BCrypt
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CommonUtil : BaseActivity() {

    fun getHash(value :String) :String{
        val passwordHashed = value

        // 위 비밀번호의 BCrypt 알고리즘 해쉬 생성
        // passwordHashed 변수는 실제 데이터베이스에 저장될 60바이트의 문자열이 된다.
        // 위 문장은 아래와 같다. 숫자가 높아질수록 해쉬를 생성하고 검증하는 시간은 느려진다.
        // 즉, 보안이 우수해진다. 하지만 그만큼 응답 시간이 느려지기 때문에 적절한 숫자를 선정해야 한다. 기본값은 10이다.
        val str = BCrypt.hashpw(passwordHashed, BCrypt.gensalt(10))

        var digest: String = ""
        digest = try {
            //암호화
            val sh = MessageDigest.getInstance("SHA-256") // SHA-256 해시함수를 사용
            sh.update(str.toByteArray()) // str의 문자열을 해싱하여 sh에 저장
            val byteData = sh.digest() // sh 객체의 다이제스트를 얻는다.


            //얻은 결과를 hex string으로 변환
            val hexChars = "0123456789ABCDEF"
            val hex = CharArray(byteData.size * 2)
            for (i in byteData.indices) {
                val v = byteData[i].toInt() and 0xff
                hex[i * 2] = hexChars[v shr 4]
                hex[i * 2 + 1] = hexChars[v and 0xf]
            }

            String(hex) //최종 결과를 String 으로 변환

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            "" //오류 뜰경우 stirng은 blank값임
        }
        digest = digest.toLowerCase();
        Log.e("", "sha256: $digest")

        return digest
    }

    fun getSha256(value :String) :String{
        val passwordHashed = value

        var digest: String = ""
        digest = try {
            //암호화
            val sh = MessageDigest.getInstance("SHA-256") // SHA-256 해시함수를 사용
            sh.update(passwordHashed.toByteArray()) // str의 문자열을 해싱하여 sh에 저장
            val byteData = sh.digest() // sh 객체의 다이제스트를 얻는다.


            //얻은 결과를 hex string으로 변환
            val hexChars = "0123456789ABCDEF"
            val hex = CharArray(byteData.size * 2)
            for (i in byteData.indices) {
                val v = byteData[i].toInt() and 0xff
                hex[i * 2] = hexChars[v shr 4]
                hex[i * 2 + 1] = hexChars[v and 0xf]
            }

            String(hex) //최종 결과를 String 으로 변환

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            "" //오류 뜰경우 stirng은 blank값임
        }
        digest = digest.toLowerCase();
        Log.e("", "sha256: $digest")

        return digest
    }

    fun getDisplaySize(context: Context): Int {
        // 꼭 DialogFragment 클래스에서 선언하지 않아도 된다.
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        return size.x
    }
}