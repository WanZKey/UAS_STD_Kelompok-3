# Informasi Detail Source Code

```kotlin
fun main() {
    val antreanRestoran = ArrayDeque<String>()
    var menu: Int
```

**Penjelasan:**

* **`fun main() {`** : Deklerasi Awal Program.
* **`val antreanRestoran = ArrayDeque<String>()`** : Wadah untuk menyimpan daftar nama pelanggan yang mengantre.
* **`var menu: Int`** : Variabel untuk menyimpan angka pilihan menu yang diketik pengguna.

---

```kotlin
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
```

**Penjelasan:**

* **`do { ...`** : Mulai perulangan agar menu terus tampil.
* Perhatikan ada tambahan **Menu [4] Cari Pelanggan**. Karena itu, pilihan Selesai sekarang bergeser menjadi **Menu [5]**.
* **`menu = readLine()?.toIntOrNull() ?: 0`** : Mengambil angka ketikan pengguna. Kalau salah ketik huruf, otomatis jadi 0.
* **`when (menu) {`** : Mengecek angka berapa yang dipilih.

---

```kotlin
            1 -> {
                println()
                // ... (tampilan judul menu)
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
                // ... (tekan ENTER untuk kembali)
            }
```

**Penjelasan:**

* **`1 -> { ... }`** : Menu tambah antrean.
* Masih sama seperti versi sebelumnya. Program mengecek nama, lalu menambahkannya ke urutan **paling belakang** menggunakan `addLast(nama)`.

---

```kotlin
            2 -> {
                println()
                // ... (tampilan judul menu)
                if (antreanRestoran.isEmpty()) {
                    println(" Info: Antrean masih kosong.")
                } else {
                    val pelanggan = antreanRestoran.removeFirst()
                    println(" Pelanggan yang dilayani :")
                    println(" $pelanggan")
                    // ... (menampilkan pelanggan berikutnya)
                }
                // ... (tekan ENTER untuk kembali)
            }
```

**Penjelasan:**

* **`2 -> { ... }`** : Menu layani pelanggan.
* Jika antrean tidak kosong, program memanggil dan menghapus nama di urutan **paling depan** menggunakan `removeFirst()`.

---

```kotlin
            3 -> {
                println()
                // ... (tampilan judul menu)
                if (antreanRestoran.isEmpty()) {
                    println(" Belum ada pelanggan yang sedang mengantre.")
                } else {
                    // ... (cetak garis tabel)
                    for ((index, nama) in antreanRestoran.withIndex()) {
                        System.out.printf("| %-6d | %-28s |\n", index + 1, nama)
                    }
                    // ... (cetak garis tabel dan jumlah antrean)
                }
                // ... (tekan ENTER untuk kembali)
            }
```

**Penjelasan:**

* **`3 -> { ... }`** : Menu lihat daftar antrean.
* Program menggunakan perulangan `for` untuk mengabsen semua pelanggan dari awal sampai akhir beserta nomor urutnya (`index + 1`).

---

```kotlin
            4 -> {
                println()
                // ... (tampilan judul menu)
                if (antreanRestoran.isEmpty()) {
                    println(" Info: Antrean masih kosong.")
                } else {
                    print(" Masukkan Nama Pelanggan : ")
                    val cari = readLine()?.trim() ?: ""
                    var ditemukan = 0

                    println()
                    // ... (cetak garis tabel)

                    for ((index, nama) in antreanRestoran.withIndex()) {
                        if (nama.contains(cari, ignoreCase = true)) {
                            System.out.printf("| %-6d | %-28s |\n", index + 1, nama)
                            ditemukan++
                        }
                    }

                    if (ditemukan > 0) {
                        // ... (cetak jumlah ditemukan)
                    } else {
                        println(" Status : Pelanggan tidak ditemukan.")
                    }
                }
                // ... (tekan ENTER untuk kembali)
            }

```

**Penjelasan:**

* **`4 -> { ... }`** : **Ini fitur barunya!** Menu untuk mencari nama.
* Pertama, program memastikan antrean tidak kosong. Kalau ada isinya, program meminta nama yang ingin dicari (`val cari`).
* **`var ditemukan = 0`** : Ini semacam "penghitung" untuk mencatat berapa banyak nama yang cocok. Awalnya diatur 0.
* **`for ((index, nama) ...`** : Program mengecek nama satu per satu di dalam antrean.
* **`if (nama.contains(cari, ignoreCase = true))`** : Ini adalah mesin pencarinya. Program mengecek apakah nama di dalam antrean *mengandung* kata yang dicari. `ignoreCase = true` artinya huruf besar/kecil tidak dipermasalahkan (contoh: nyari "budi" akan tetap ketemu "Budi" atau "BUDI").
* Jika ketemu, datanya dicetak ke tabel dan nilai `ditemukan` ditambah 1 (`ditemukan++`). Jika di akhir nilai `ditemukan` masih 0, berarti nama tidak ada.

---

```kotlin
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
                // ... (tekan ENTER untuk coba lagi)
            }
        }

    } while (menu != 5)
}

```

**Penjelasan:**

* **`5 -> { ... }`** : Menu untuk selesai sekarang pindah ke nomor 5.
* **`else -> { ... }`** : Menangani jika pengguna salah ketik angka (misal angka 9).
* **`} while (menu != 5)`** : Perulangan program akan terus berjalan *selama* angka yang diketik bukan 5. Jika ketik 5, program berhenti.