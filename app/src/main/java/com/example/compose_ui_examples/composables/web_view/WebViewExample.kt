package com.example.compose_ui_examples.composables.web_view

import android.content.Intent
import android.net.Uri
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun WebViewExample() {

    //source https://medium.com/@sahar.asadian90/webview-in-jetpack-compose-71f237873c2e#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjBlNzJkYTFkZjUwMWNhNmY3NTZiZjEwM2ZkN2M3MjAyOTQ3NzI1MDYiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJuYmYiOjE3MDEwNzY2NTcsImF1ZCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjEwMjcyODU4ODE0NzUxNTcyMTgzOCIsImVtYWlsIjoibWIubWFzb3VtaTEwMDBAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF6cCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsIm5hbWUiOiJtYXNvdW1pIDEwMDAiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUNnOG9jTEVQZmxlRXN2a09NUUtSV2o1T2FDYlVMUThQd0N4WlBOaTI3eS03LUFBbWc9czk2LWMiLCJnaXZlbl9uYW1lIjoibWFzb3VtaSIsImZhbWlseV9uYW1lIjoiMTAwMCIsImlhdCI6MTcwMTA3Njk1NywiZXhwIjoxNzAxMDgwNTU3LCJqdGkiOiJkZmY2NDE4YzkwZWQxMmU5YTI2NjM4NjJmZDllMDI5ZTQ2MzFiZjgyIn0.K9UrYA-aCW0sEU_iFRgmZ5lhRchFixJrcgkZ6M1ICpQ0spoIxirJy_Qud2AEjX9k2vANik-pJxTfIQRdOfoHfFF5UOCCNSEJn-kycwMgiJa21Qai1xmpJYAk1hiFjYPBV8ILRAOroZYPWvp2tMC0Gt01S9CBamlLtd1oNszpW7O5CrABbcuqWnMV-arcJNtz69lVdBl_xKL4fDTXVRA7RR7_E4Lm_dEBG3DRvJxAvUAVy0XaE1PS8TT0N0lHOkeMiCYo_SZR5_YPTZ1CJwWvc4XesZJtNoq5id23cbqEgzaRgxrThIs2y0NeeEx68Y27ckWLbZyP9bWcJzKBa3f3kA

    Surface(modifier = Modifier.statusBarsPadding()){
//        Example1()
        Example2()
    }


}


@Composable
fun Example1() {

    AndroidView(
        factory = { context ->

            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(false)
            }
        },

        update = { webView ->
           webView.loadUrl("https://www.ldoceonline.com/")
        }
    )

}


@Composable
fun Example2(webViewClient: WebViewClient = WebViewClient()) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                this.webViewClient = webViewClient
            }
        },
        update = { webView ->
            webView.loadUrl("https://www.ldoceonline.com/")
        }
    )

}


//The above sample WebViewClientwill only allow redirects to URLs that start with https://example.com
class CustomWebViewClient: WebViewClient(){
    @Deprecated("Deprecated in Java")
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if(url != null && url.startsWith("https://example.com")){
            view?.loadUrl(url)
            return true
        }
        return false
    }

}


//*****************************************************************************************

@Composable
fun Example3(
    activity: ComponentActivity,
    url: String
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webChromeClient = customWebChromeClient()
                loadUrl(url)
            }
        }
    )
}

private fun customWebChromeClient(): WebChromeClient {
    val webChromeClient = object : WebChromeClient() {
        override fun onShowFileChooser(
            webView: WebView,
            filePathCallback: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            openFileChooser(filePathCallback)
            return true
        }
    }
    return webChromeClient
}

private fun openFileChooser(filePathCallback: ValueCallback<Array<Uri>>) {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = "*/*"
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
}
