SUMMARY = "Interactive process viewer"
HOMEPAGE = "http://hisham.hm/htop"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=c312653532e8e669f30e5ec8bdc23be3"

DEPENDS = "ncurses"

SRC_URI = "http://hisham.hm/htop/releases/${PV}/${BP}.tar.gz \
           file://0001-Use-pkg-config.patch"
SRC_URI[md5sum] = "f262b66ad6c194782f4d3a80627e84c8"
SRC_URI[sha256sum] = "3260be990d26e25b6b49fc9d96dbc935ad46e61083c0b7f6df413e513bf80748"

inherit autotools pkgconfig

PACKAGECONFIG ??= "proc \
                   cgroup \
                   taskstats \
                   unicode \
                   linux-affinity \
                   delayacct"
PACKAGECONFIG[proc] = "--enable-proc,--disable-proc"
PACKAGECONFIG[openvz] = "--enable-openvz,--disable-openvz"
PACKAGECONFIG[cgroup] = "--enable-cgroup,--disable-cgroup"
PACKAGECONFIG[vserver] = "--enable-vserver,--disable-vserver"
PACKAGECONFIG[taskstats] = "--enable-taskstats,--disable-taskstats"
PACKAGECONFIG[unicode] = "--enable-unicode,--disable-unicode"
PACKAGECONFIG[linux-affinity] = "--enable-linux-affinity,--disable-linux-affinity"
PACKAGECONFIG[hwloc] = "--enable-hwloc,--disable-hwloc,hwloc"
PACKAGECONFIG[setuid] = "--enable-setuid,--disable-setuid"
PACKAGECONFIG[delayacct] = "--enable-delayacct,--disable-delayacct,libnl"

do_configure_prepend () {
    rm -rf ${S}/config.h
}
