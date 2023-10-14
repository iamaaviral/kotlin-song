@file:JsModule("react-player")
@file:JsNonModule

import react.*

@JsName("default")
external val ReactPlayer: ComponentClass<ReactPlayerProps>

external interface ReactPlayerProps : Props {
    var url: String
    var playing: Boolean
    var controls: Boolean
    var width: String
    var height: String
    var volume: Double
    var onStart: () -> Unit
    var style: dynamic
    var isVisible: Boolean
}