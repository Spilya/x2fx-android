package pet.yiffiy.spilya

import java.net.URI

class UrlReplacer {
    fun supports(url: URI): Boolean {
        return url.host == "x.com" || url.host == "bsky.app"
    }

    fun replaceDomainName(url: URI): URI {
        if (!supports(url)) {
            return url
        }
        val newHost = when (url.host) {
            "x.com" -> "fixupx.com"
            "bsky.app" -> "fxbsky.app"
            else -> url.host
        }
        return URI(
            url.scheme,
            url.userInfo,
            newHost,
            url.port,
            url.path,
            // removes query and fragment
            null,
            null,
        )
    }
}
