fun main() {
    val antreanRestoran = ArrayDeque<String>()
    var menu: Int

    do {
        println("===================================================")
        println("     PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS")
        println("===================================================")
        println(" [1] Pelanggan Baru (Enqueue)")
        println(" [2] Layani Pelanggan (Dequeue)")
        println(" [3] Lihat Daftar Antrean")
        println(" [4] Cari Pelanggan")
        println(" [5] Selesaikan Program")
        println("===================================================")
        print(" Masukkan Pilihan Anda (1-5): ")

        menu = readLine()?.toIntOrNull() ?: 0

        when (menu) {

            1 -> {
                println()
                println("===================================================")
                println("             TAMBAH PELANGGAN BARU")
                println("===================================================")
                println()

                print(" Masukkan Nama Pelanggan : ")
                val nama = readLine()?.trim() ?: ""

                if (nama.isNotEmpty()) {
                    antreanRestoran.addLast(nama)
                    println()
                    println(" Sukses: '$nama' berhasil masuk antrean.")
                } else {
                    println()
                    println(" Gagal: Nama pelanggan tidak boleh kosong.")
                }

                println("\n===================================================")
                print(" Tekan ENTER untuk kembali ke menu...")
                readLine()
                println()
            }

            2 -> {
                println()
                println("===================================================")
                println("               LAYANI PELANGGAN")
                println("===================================================")
                println()

                if (antreanRestoran.isEmpty()) {

                    println(" Info: Antrean masih kosong.")

                } else {

                    val pelanggan = antreanRestoran.removeFirst()

                    println(" Pelanggan yang dilayani :")
                    println(" $pelanggan")
                    println()

                    println(" Pelanggan berikutnya :")
                    if (antreanRestoran.isNotEmpty()) {
                        println(" ${antreanRestoran.first()}")
                    } else {
                        println(" Tidak ada pelanggan berikutnya.")
                    }
                }

                println("\n===================================================")
                print(" Tekan ENTER untuk kembali ke menu...")
                readLine()
                println()
            }

            3 -> {
                println()
                println("===================================================")
                println("             DAFTAR ANTREAN SAAT INI")
                println("===================================================")
                println()

                if (antreanRestoran.isEmpty()) {

                    println(" Belum ada pelanggan yang sedang mengantre.")

                } else {

                    println("+--------+------------------------------+")
                    println("| No     | Nama Pelanggan               |")
                    println("+--------+------------------------------+")

                    for ((index, nama) in antreanRestoran.withIndex()) {
                        System.out.printf("| %-6d | %-28s |\n", index + 1, nama)
                    }

                    println("+--------+------------------------------+")
                    println()
                    println(" Jumlah antrean : ${antreanRestoran.size} pelanggan")
                }

                println("\n===================================================")
                print(" Tekan ENTER untuk kembali ke menu...")
                readLine()
                println()
            }

            4 -> {
                println()
                println("===================================================")
                println("               CARI PELANGGAN")
                println("===================================================")
                println()

                if (antreanRestoran.isEmpty()) {

                    println(" Info: Antrean masih kosong.")

                } else {

                    print(" Masukkan Nama Pelanggan : ")
                    val cari = readLine()?.trim() ?: ""

                    var ditemukan = 0

                    println()

                    println("+--------+------------------------------+")
                    println("| No     | Nama Pelanggan               |")
                    println("+--------+------------------------------+")

                    for ((index, nama) in antreanRestoran.withIndex()) {

                        if (nama.contains(cari, ignoreCase = true)) {
                            System.out.printf("| %-6d | %-28s |\n", index + 1, nama)
                            ditemukan++
                        }
                    }

                    if (ditemukan > 0) {
                        println("+--------+------------------------------+")
                        println()
                        println(" Jumlah ditemukan : $ditemukan pelanggan")
                    } else {
                        println(" Status : Pelanggan tidak ditemukan.")
                    }
                }

                println("\n===================================================")
                print(" Tekan ENTER untuk kembali ke menu...")
                readLine()
                println()
            }

            5 -> {
                println()
                println("===================================================")
                println("                PROGRAM SELESAI")
                println("===================================================")
                println()
            }

            else -> {
                println()
                println(" Error: Pilihan tidak valid.")

                println("\n===================================================")
                print(" Tekan ENTER untuk coba lagi...")
                readLine()
                println()
            }
        }

    } while (menu != 5)
}
