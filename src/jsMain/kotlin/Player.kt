import react.FC
import react.Props
import csstype.*

import emotion.react.css
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span

import react.dom.html.ReactHTML.img
import kotlin.time.Duration.Companion.seconds

external interface PlayerProps : Props {
    var songs: Array<Song>
    var currentSong: Song
}

val Player = FC<PlayerProps> { props ->

    div {
        css {
            backgroundColor = Color("#f0f3f4")
            bottom = 0.px
            boxShadow = BoxShadow(0.px, -5.px, 15.px, 5.px, rgba(0,0,0,0.3))
            color = Color("black")
            display = Display.flex
            flexDirection = FlexDirection.row
            justifyContent = JustifyContent.spaceBetween
            height = 100.px
            alignItems = AlignItems.center
            marginTop = 20.px
            padding = Padding(0.px, 16.px)
            position = Position.absolute
            width = 100.pct
        }
        div {
            css {
                minWidth = 180.px
                width = 30.pct
                height = 100.pct
                display = Display.flex
                alignItems = AlignItems.center
                justifyContent = JustifyContent.flexStart
                gap = 8.px
            }
            div {
                css {
//                    flex: Flex(0)
                }
                img {
                    src = props.currentSong.image
                    alt = "song-img"
                    css {
                        display= Display.block
                        borderRadius = 4.px
                        width = 56.px
                        height = 56.px
                    }
                }
            }
            div {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                    alignItems = AlignItems.flexStart
                    gap = 8.px
                    overflow = Overflow.hidden
                }
                div {
                    css {
                        maxWidth = 100.pct
                        margin = 0.px
                        overflow = Overflow.hidden
                        whiteSpace = WhiteSpace.nowrap
                        textOverflow = TextOverflow.ellipsis
                        fontSize = 14.px
                    }
                    +props.currentSong.name
                }
                div {
                    css {
                        maxWidth = 100.pct
                        margin = 0.px
                        overflow = Overflow.hidden
                        whiteSpace = WhiteSpace.nowrap
                        textOverflow = TextOverflow.ellipsis
                        fontSize = 14.px
                    }
                    +props.currentSong.artist
                }
            }
        }
        div {
            css {
                display= Display.flex
                flexDirection = FlexDirection.column
                alignItems = AlignItems.center
                justifyContent = JustifyContent.center
                gap = 8.px
                width = 100.pct
            }
            div {
                css {
                    display= Display.flex
                    justifyContent= JustifyContent.center
                    alignItems = AlignItems.center
                    gap= 16.px
                }
                div {
                    css {
                        gap = 16.px
                        display = Display.flex
                        alignItems = AlignItems.center
                        justifyContent = JustifyContent.center
                    }
                    button {

                    }
                }
            }
            div {
                css {
                    position= Position.relative
                    marginTop= 8.px
                    display= Display.flex
                    justifyContent= JustifyContent.spaceBetween
                    alignItems= AlignItems.center
                    width = 100.pct
                    gap = 8.px
                }
                div {
                    css {
                        margin = Margin(0.px, 24.px)
                        width= 100.pct
                    }
                    ReactPlayer {
                        url = props.currentSong.url
                        controls = true
                        width = "100%"
                        height = "56px"
                        playing = true
                    }
                }
            }
        }
    }

}