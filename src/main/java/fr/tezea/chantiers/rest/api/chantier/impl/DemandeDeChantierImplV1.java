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
package fr.tezea.chantiers.rest.api.chantier.impl;

import fr.tezea.chantiers.rest.api.chantier.api.DemandeDeChantierResourceV1;
import fr.tezea.chantiers.service.DemandeDeChantierService;
import fr.tezea.chantiers.service.dto.chantier.DemandeDeChantierDTO;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemandeDeChantierImplV1 implements DemandeDeChantierResourceV1
{
    private final DemandeDeChantierService demandeDeChantierService;

    public DemandeDeChantierImplV1(DemandeDeChantierService demandeDeChantierService)
    {
        super();
        this.demandeDeChantierService = demandeDeChantierService;
    }

    @Override
    public ResponseEntity<DemandeDeChantierDTO> getDemandeDeChantierById(@PathVariable("id") long id)
    {
        return ResponseEntity.ok(this.demandeDeChantierService.getDemandeDeChantierById(id));
    }

    @Override
    public ResponseEntity<URI> addDemandeDeChantier(@RequestBody DemandeDeChantierDTO demandeDeChantierDTO)
    {
        URI location = URI.create(
                String.format("/get/%s", this.demandeDeChantierService.addDemandeDeChantier(demandeDeChantierDTO)));
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<DemandeDeChantierDTO> updateDemandeDeChantierById(@PathVariable("id") long id,
            @RequestBody DemandeDeChantierDTO demandeDeChantierDTO)
    {
        return ResponseEntity.ok(this.demandeDeChantierService.updateDemandeDeChantierById(id, demandeDeChantierDTO));
    }

    @Override
    public ResponseEntity<Void> deleteDemandeDeChantierById(@PathVariable("id") long id)
    {
        this.demandeDeChantierService.deleteDemandeDeChantierById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}