/*
 * MIT License
 *
 * Copyright (c) 2021 TEZEA-Chantiers
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package fr.tezea.chantiers.rest.api.chantier.api;

import fr.tezea.chantiers.service.dto.chantier.RapportChantierRegulierDTO;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rapportchantierregulier")
public interface RapportChantierRegulierRessourceV1
{
    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<RapportChantierRegulierDTO> getRapportChantierRegulierById(@PathVariable("id") long id);

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<List<RapportChantierRegulierDTO>> getAllRapportChantierRegulier();

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<URI> addRapportChantierRegulier(
            @RequestBody RapportChantierRegulierDTO rapportChantierRegulierDTO);

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<RapportChantierRegulierDTO> updateRapportChantierRegulierById(@PathVariable("id") long id,
            @RequestBody RapportChantierRegulierDTO rapportChantierRegulierDTO);

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteRapportChantierRegulierById(@PathVariable("id") long id);
}
