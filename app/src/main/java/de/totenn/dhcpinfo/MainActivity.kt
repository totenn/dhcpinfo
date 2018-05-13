package de.totenn.dhcpinfo

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.textView).apply {
            text = fetchDhcpInfo()
        }
    }

    private fun fetchDhcpInfo(): String {
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val dhcpInfo = wifiManager.dhcpInfo
        if (dhcpInfo != null){
        return dhcpInfo.toString()
        }
        return notifUserInfo(context, "no Wi-Fi connection")
    }
}
