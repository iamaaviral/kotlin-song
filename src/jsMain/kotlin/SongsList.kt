import kotlinx.browser.window
import react.*
import react.dom.*
import csstype.*

import emotion.react.css
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.h5

external interface SongListProps : Props {
    var songs: Array<Song>
    var onSelectSong: (Song) -> Unit
    var currentSong: Song
}

val SongList = FC<SongListProps> { props ->
    div {
        css {
            height = 90.vh
            overflow =  Overflow.scroll
            padding= 32.px
            scrollbarWidth = ScrollbarWidth.thin
        }
        div {

            css {
                display= Display.grid
                gap= 35.px
                justifyContent = JustifyContent.spaceBetween
                gridTemplateColumns= repeat(AutoRepeat.autoFill, minmax(250.px, 1.fr))
            }
            for(song in props.songs) {
                div {
                    css {
                        cursor = Cursor.pointer
                        boxShadow = BoxShadow(0.px , 2.px, 2.px, 2.px, rgba(0,0,0,0.3))
                        height = 100.pct
                        padding = 16.px
                        display = Display.flex
                        flexDirection = FlexDirection.column
                        alignItems = AlignItems.center
                        justifyContent = JustifyContent.spaceBetween
                        color = Color("black")
                        boxShadow = if(song === props.currentSong) BoxShadow(0.px, 2.px, 5.px, 0.px, Color("#1db954")) else BoxShadow(1.px, 2.px, 5.px, 0.px, Color("black"))
                    }
                    key = song.id.toString()
                    onClick = {
                        props.onSelectSong(song)
                    }
                    div {
                        css {
//                            flex = Flex(1,1,0)
                            overflow= Overflow.hidden
                            marginBottom= 16.px
                        }
                        img {
                            css {
                                objectFit = ObjectFit.scaleDown
                                display = Display.block
                                width = 100.pct
                                height = 100.pct
                            }
                            src = song.image
                        }
                    }
                    div {
                        h3 {
                            +song.name
                        }
                        h5 {
                            +song.artist
                        }
                    }
                }

            }
        }
    }
}