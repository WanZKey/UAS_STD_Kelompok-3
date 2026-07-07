# Informasi Kode

```kotlin
fun main() {
    val antreanRestoran = ArrayDeque<String>()
    var menu: Int
```

**Penjelasan:**

* **`fun main() {`** : Deklarasi awal program.
* **`val antreanRestoran = ArrayDeque<String>()`** : Kita membuat sebuah wadah antrean kosong bernama `antreanRestoran`. Wadah ini khusus untuk menyimpan teks (`String`), yaitu nama pelanggan nantinya. Konsepnya seperti barisan antrean nyata (siapa masuk duluan, keluar duluan).
* **`var menu: Int`** : Kita menyiapkan tempat penampungan (variabel) bernama `menu` yang khusus untuk menyimpan angka (`Int`) dari pilihan pengguna.

---

```kotlin
    do {
        println("===================================================")
        println("        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS")
        println("===================================================")
        println(" [1] Pelanggan Baru (Enqueue)")
        println(" [2] Layani Pelanggan (Dequeue)")
        println(" [3] Lihat Daftar Antrean")
        println(" [4] Selesaikan Program")
        println("===================================================")
        print(" Masukkan Pilihan Anda (1-4): ")

        menu = readLine()?.toIntOrNull() ?: 0

        when (menu) {

```

**Penjelasan:**

* **`do { ...`** : Ini adalah perintah untuk **mengulang**. Program akan mencetak tampilan menu ini berulang kali ke layar (menggunakan `println`).
* **`menu = readLine()?.toIntOrNull() ?: 0`** : Program membaca apa yang diketik oleh pengguna di keyboard (`readLine()`), lalu mencoba mengubah ketikan itu menjadi angka (`toIntOrNull()`). Kalau pengguna iseng ngetik huruf atau mengosongkannya, otomatis nilainya diubah jadi `0`.
* **`when (menu) {`** : Program mengecek, angka berapa yang dimasukkan pengguna tadi? Di blok selanjutnya, kita akan mengatur apa yang terjadi untuk setiap angka.

---

```kotlin
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
                    println("\n Sukses: '$nama' berhasil masuk antrean.")
                } else {
                    println("\n Gagal: Nama pelanggan tidak boleh kosong.")
                }

                println("\n===================================================")
                print(" Tekan ENTER untuk kembali ke menu...")
                readLine()
                println()
            }

```

**Penjelasan:**

* **`1 -> { ... }`** : Ini yang terjadi kalau pengguna memilih angka 1.
* **`val nama = readLine()?.trim() ?: ""`** : Program meminta nama, lalu membuang spasi kosong di awal/akhir ketikan (`trim()`).
* **`if (nama.isNotEmpty())`** : Mengecek apakah namanya ada isinya (tidak kosong).
* **`antreanRestoran.addLast(nama)`** : Jika namanya ada, nama tersebut dimasukkan ke **paling belakang** barisan antrean.
* **`readLine()` di akhir** : Ini sekadar jeda, menunggu pengguna menekan ENTER sebelum menu utama dimunculkan lagi.

---

```kotlin
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

```

**Penjelasan:**

* **`2 -> { ... }`** : Ini yang terjadi kalau pengguna memilih angka 2.
* **`if (antreanRestoran.isEmpty())`** : Cek dulu, apakah antreannya kosong? Kalau iya, beri tahu pengguna.
* **`val pelanggan = antreanRestoran.removeFirst()`** : Kalau ada yang antre, ambil nama yang ada di **paling depan**, lalu **hapus** dari barisan antrean karena sudah dilayani.
* **`antreanRestoran.first()`** : Mengintip siapa nama yang ada di urutan paling depan *sekarang* (setelah orang sebelumnya dilayani), tanpa menghapusnya dari antrean.

---

```kotlin
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

```

**Penjelasan:**

* **`3 -> { ... }`** : Ini yang terjadi kalau pengguna memilih angka 3.
* **`for ((index, nama) in antreanRestoran.withIndex())`** : Program mengecek (mengabsen) antrean satu per satu dari depan ke belakang. `index` adalah nomor urutnya (dimulai dari 0, makanya di bawahnya ditulis `index + 1`), dan `nama` adalah nama pelanggannya.
* **`antreanRestoran.size`** : Menghitung dan menampilkan total berapa orang yang saat ini sedang berada di dalam antrean.

---

```kotlin
            4 -> {
                println()
                println("===================================================")
                println("                PROGRAM SELESAI")
                println("===================================================")
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

    } while (menu != 4)
}

```

**Penjelasan:**

* **`4 -> { ... }`** : Kalau pengguna memilih angka 4, program hanya mencetak teks "PROGRAM SELESAI".
* **`else -> { ... }`** : Ini adalah "jaring pengaman". Kalau pengguna memasukkan angka di luar 1, 2, 3, atau 4 (misal angka 9), program akan masuk ke sini dan bilang pilihan tidak valid.
* **`} while (menu != 4)`** : Ini adalah penutup dari perintah `do` di bagian paling atas tadi. Artinya: *"Terus ulangi semua proses di atas, **selama** angka menu bukan 4"*. Begitu angka yang dimasukkan adalah 4, perulangan berhenti, dan program tamat.

---

# Implementasi Program

## 1. Menambah Data Pelanggan
```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 1

===================================================
             TAMBAH PELANGGAN BARU
===================================================

 Masukkan Nama Pelanggan : Radisa Arisandi

 Sukses: 'Radisa Arisandi' berhasil masuk antrean.

===================================================
```

Menambah ```Radisa Arisandi``` ke dalam antrean.

```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 1

===================================================
             TAMBAH PELANGGAN BARU
===================================================

 Masukkan Nama Pelanggan : Riduan

 Sukses: 'Riduan' berhasil masuk antrean.

===================================================
```

Menambah ```Riduan``` ke dalam antrean.

```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 1

===================================================
             TAMBAH PELANGGAN BARU
===================================================

 Masukkan Nama Pelanggan : Viona Diva Shifana

 Sukses: 'Viona Diva Shifana' berhasil masuk antrean.

===================================================
```

Menambah ```Viona Diva Shifana``` ke dalam antrean.

## 2. Melihat isi Daftar Antrean

```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 3

===================================================
             DAFTAR ANTREAN SAAT INI
===================================================

+--------+------------------------------+
| No     | Nama Pelanggan               |
+--------+------------------------------+
| 1      | Radisa Arisandi              |
| 2      | Riduan                       |
| 3      | Viona Diva Shifana           |
+--------+------------------------------+

 Jumlah antrean : 3 pelanggan

===================================================
```

Bisa di lihat bahwa pada daftar antrean tersebut berisi nama yang telah ditambahkan sebelumnya, serta ada informasi ```Jumlah Antrean```.

## 3. Melayani Pelanggan
```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 2

===================================================
               LAYANI PELANGGAN
===================================================

 Pelanggan yang dilayani :
 Radisa Arisandi

 Pelanggan berikutnya :
 Riduan

===================================================
```

Ketika sedang melayani pelanggan pertama yang dimasukkan datanya maka akan ada informasi untuk pelanggan berikutnya yang akan dilayani.

```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 2

===================================================
               LAYANI PELANGGAN
===================================================

 Pelanggan yang dilayani :
 Viona Diva Shifana

 Pelanggan berikutnya :
 Tidak ada pelanggan berikutnya.

===================================================
```

Bisa di lihat pada informasi diatas, jika sudah tidak ada lagi data untuk pelanggan berikutnya maka program akan mengeluarkan output ``` Tidak ada pelanggan berikutnya.```.

```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 2

===================================================
               LAYANI PELANGGAN
===================================================

 Info: Antrean masih kosong.

===================================================
```

Namun apabila ingin melayani pelanggan dan antrean sedang kosong maka akan muncul output ` Info: Antrean masih kosong.`.

## 4. Menghentikan Program

```text
===================================================
        PROGRAM MANAJEMEN ANTRIAN KANTIN KAMPUS
===================================================
 [1] Pelanggan Baru (Enqueue)
 [2] Layani Pelanggan (Dequeue)
 [3] Lihat Daftar Antrean
 [4] Selesaikan Program
===================================================
 Masukkan Pilihan Anda (1-4): 4

===================================================
                PROGRAM SELESAI
===================================================
```

Untuk menghentikan program pilih opsi `4` maka program akan selesai.